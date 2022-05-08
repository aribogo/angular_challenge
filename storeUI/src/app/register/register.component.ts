import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  error : string = "";
  errors = null;
  form: any = {
    name: null,
    cpf: null,
    email: null
  };
  isSuccessful = false;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { name, email, cpf } = this.form;

    this.authService.register(name, email, cpf).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
      },
      err => {
        this.error = "We had problems trying to sign you up. Please verify the information submitted or try again later."
        this.errors = err;
      }
    );
  }

}
