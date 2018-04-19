import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {
  private url = 'http://localhost:8080/onlinemarket/signin';

  constructor(private http: Http) { }

  signin(user) {
    return this.http.get(this.url, user)
      .map(response => response.json());
  }

}
