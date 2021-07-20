import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-onboarding',
  templateUrl: './onboarding.component.html',
  styleUrls: ['./onboarding.component.css']
})
export class OnboardingComponent implements OnInit {

  email:string
  filedata:any
  firstName:string
  lastName:string
  preferName:string
  tel:string
  ssn:string
  bday:string
  gender:string
  constructor() 
  {
    this.email="";
    this.firstName="";
    this.lastName="";
    this.preferName="";
    this.tel="";
    this.ssn="";
    this.bday="";
    this.gender="";
  }

  ngOnInit(): void {
    return this.http.post(this.email, httpOptions);
    return this.http.post(this.firstName, httpOptions);
    return this.http.post(this.lastName, httpOptions);
    return this.http.post(this.preferName, httpOptions);
    return this.http.post(this.tel, httpOptions);
    return this.http.post(this.ssn, httpOptions);
    return this.http.post(this.bday, httpOptions);
    return this.http.post(this.gender, httpOptions);
    
  }

}
