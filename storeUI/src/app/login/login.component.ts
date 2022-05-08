import { Component, OnInit } from '@angular/core';
import { Token } from '../dtos/token';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error : string = "";
  errors = null;
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  roles: string[] = [];
  token!: Token;


  constructor(private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
    this.tokenStorage.saveUser(username);
    this.authService.login(username, password).subscribe(
      data => {
        this.token = data;
        this.tokenStorage.saveToken(this.token.token);
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
      },
      err => {
        this.error = "We had problems trying to sign you up. Please verify the information sent or try again later."
        this.errors = err;
        
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
