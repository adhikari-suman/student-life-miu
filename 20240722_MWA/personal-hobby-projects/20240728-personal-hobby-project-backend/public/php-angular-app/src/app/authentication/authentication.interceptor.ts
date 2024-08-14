import {HttpInterceptorFn} from '@angular/common/http';
import {inject} from "@angular/core";
import {AuthenticationService} from "./authentication.service";
import {environment} from "../../environments/environment";

export const authenticationInterceptor: HttpInterceptorFn = (req, next) => {
  const authenticationService = inject(AuthenticationService);

  if (authenticationService.token.length === 0) {
    return next(req);
  }

  const authorizationHeader = environment.authorizationHeader;

  const headers = {
    [authorizationHeader]: environment.bearerToken(authenticationService.token)
  }
  
  return next(req.clone(
      {
        setHeaders: headers,
      }
    ),
  );
};
