import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: string;
  password: string;

  constructor() { 
    this.userName = "";
    this.password = "";

  }

  ngOnInit(): void {
  }
  onSubmit() {
    return this.http.post(this.userName, httpOptions);
    return this.http.post(this.password, httpOptions)
  }
}
