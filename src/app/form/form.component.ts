import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, NgModule } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule,HttpClientModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  State:any=[]
  urlCity:string="http://localhost:8080/location/display-by-stateid/"
  stateId:any=""
  City:any=[]
  req:boolean=false
  req1:boolean=false
  playersInsert:string="http://localhost:8080/player/insert-player"
  constructor(private http:HttpClient){
    this.getDate()

  }
  fmdata:FormGroup=new FormGroup({
    playerid:new FormControl(null),
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required,Validators.email]),
    phonenumber:new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),Validators.minLength(10),Validators.maxLength(10)]),
    password:new FormControl('', [Validators.required,Validators.minLength(8),Validators.maxLength(16)]),
    address:new FormControl('', [Validators.required]),
    gen:new FormControl('', [Validators.required]),
    sd:new FormControl('', [Validators.required]),
    dob:new FormControl('', [Validators.required]),
    role:new FormControl(null),
    
  })
  ids:FormGroup=new FormGroup({
    stateid:new FormControl('', [Validators.required]),
    password:new FormControl('', [Validators.required,Validators.minLength(8),Validators.maxLength(16)]),
  })
  get errSd():any{
    return this.fmdata.get('sd')
  }
  get errName():any{
    return this.fmdata.get('name')
  }
  get errEmail():any{
    return this.fmdata.get('email')
  }
  get errStateid():any{
    return this.ids.get('stateid')
  }
  get errConpass():any{
    return this.ids.get('password')
  }
  get errPone():any{
    return this.fmdata.get('phonenumber')
  }
  get errPassword():any{
    return this.fmdata.get('password')
  }
  get errAddress():any{
    return this.fmdata.get('address')
  }
  get errGen():any{
    return this.fmdata.get('gen')
  }
  get errDob():any{
    return this.fmdata.get('dob')
  }
  clickAct(){
    this.req1=true
  }
  getDate() {
    this.http.get("http://localhost:8080/location/show-data").subscribe(
      (data) => {
        
        this.State = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }
  sub(form:FormGroup){
    this.req=true
    if(this.fmdata.errors){
      alert("Something Went Wrong")
    }
    else{
      this.http.post(this.playersInsert,form.value).subscribe(
        (data) => {
          
          alert("Insert Data")
        },
        (eror) => {
         alert("Errors")
          console.log(eror);
        }
      );
    }
  }
  changeState(){
  this.stateId=this.ids.get('stateid')?.value
    this.http.get(this.urlCity+this.stateId).subscribe(
      (data) => {
        
        this.City = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }

}
