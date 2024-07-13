import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent  {
  loginData:any=[]
  isVali:boolean=false
  messege:string=""
  login:any=[]
  id:String="0"
  constructor(private http:HttpClient,private router: Router){
   
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  fmData: FormGroup = new FormGroup({
    user: new FormControl('', [Validators.required]),
    password: new FormControl('',[Validators.required])
  });
  mymodel:any=''
  mychange(event:FormGroup):any{
    if(this.fmData.get("user")?.errors){
      console.log(this.fmData.controls["user"]?.validator)
    }
  }
  
  get erruser():any{
    return this.fmData.get("user");
  }
  get errPass():any{
    return this.fmData.get("password");
  }
  isEmail(str:string):boolean {
    // Basic email regex pattern
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailPattern.test(str);
  }
  data:FormGroup=new FormGroup({
    playerid:new FormControl(null),
    name: new FormControl(null),
    email: new FormControl(null, [Validators.required,Validators.email]),
    phonenumber:new FormControl(null, [Validators.required,Validators.pattern('[0-9]*'),Validators.minLength(10),Validators.maxLength(10)]),
    password:new FormControl(null, [Validators.required]),
    address:new FormControl(null),
    gen:new FormControl(null),
    sd:new FormControl(null),
    dob:new FormControl(null ),
    role:new FormControl(null),
    
  })
 get phoneErr():any{
  return this.data.get('phonenumber')
 }
 get emailErr():any{
  return this.data.get('email')
 }
  sub(fm:FormGroup){
    if(fm.valid){
      if(this.isEmail(fm.value.user)){
        
        this.data.get('email')?.setValue(fm.value.user);
        this.data.get('password')?.setValue(fm.value.password)
        if(!this.emailErr.errors){
          
            this.http.post("http://localhost:8080/player/login/eml",this.data.value).subscribe(
              (data) => {
                this.login=data
              
                this.id=this.login.playerid;
               
               
                if(data!=null){
                  this.http.get("http://localhost:8080/location/set-cookie/"+this.id,{responseType:"text"} ).subscribe(
                    (cit) => {
                      alert(cit)
                    
                      this.router.navigate(['/action', { data: this.id }]);
                    },
                    (error)=>{
                      console.log(error)
                      alert("Error")
                    }
                  );
                }
               
              },
              (eror) => {
               
                console.log(eror);
              }
            );
        }
        else{
          alert("Email not")
        }
      }
      else{
        this.data.get('phonenumber')?.setValue(fm.value.user);
        this.data.get('password')?.setValue(fm.value.password)
       
        if(!this.phoneErr?.errors)
          this.http.post("http://localhost:8080/player/login/phn",this.data.value).subscribe(
            (data) => {
              this.login=data
              this.id=this.login.playerid;
              this.http.get("http://localhost:8080/location/set-cookie/"+this.id,{responseType:"text"} ).subscribe(
                (cit) => {
                  alert(cit)
                  this.router.navigate(['/action', { data: this.id }]);
                },
                (error)=>{
                  console.log(error)
                  alert("Error")
                }
              );
             
            },
            (eror) => {
             
              console.log(eror);
            }
          );
       
      }

    }
    else{
      alert("Error")
    }
    
  }
  mychange1(event:string){
    
    return"Elivsh";
  }
}
