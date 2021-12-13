package fr.doranco.ecommerce.rest.jersey.server.provider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	
	private Response getAccessDeniedResponse() {
		return Response.status(Status.UNAUTHORIZED).entity("Vous n'avez pas le droit d'accès à cette resource !").build();
	}
	
	private Response getAccessForbiddenResponse() {
		return Response.status(Status.FORBIDDEN).entity("Accès bloqué à tous les utilisateurs !!").build();
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Method method = resourceInfo.getResourceMethod();
		
		if(!method.isAnnotationPresent(PermitAll.class)) {
			if(method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(getAccessForbiddenResponse());
				return;
			}
		}
		
		if(requestContext.getUriInfo().getPath().toString().contains("application.wadl")
				||method.isAnnotationPresent(PermitAll.class)) {
			return;
		}
		
		final MultivaluedMap<String, String> headers = requestContext.getHeaders();
		
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
		
		if(authorization == null || authorization.isEmpty()) {
			requestContext.abortWith(getAccessDeniedResponse());
			return;
		}
		
		final String encodedAndPasswordAndRole = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME+"", "");
		
		String usernameAndPassword = new String(Base64.getDecoder().decode(encodedAndPasswordAndRole.getBytes()));
		
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword,":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		final String userRole = tokenizer.nextToken();
		
		if(method.isAnnotationPresent(RolesAllowed.class)) {
			RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
			Set<String> roleSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
			
			if(!isUserAllowed(username,password,userRole,roleSet)) {
				requestContext.abortWith(getAccessDeniedResponse());
				return;
			}
		}	
	}
	
	private boolean isUserAllowed(	final String username, 
									final String password,
									final String userRole,
									final Set<String> roleSet) {
		boolean isAllowed = false;
		
		if(username.equals("toto") && password.equals("titi")) {	
			if(roleSet.contains(userRole)) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}

}
