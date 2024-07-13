import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-players',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule,HttpClientModule],
  templateUrl: './players.component.html',
  styleUrl: './players.component.css'
})
export class PlayersComponent {
  id:any=""
  emailUpd:boolean=false
  roleup:boolean=false
  phoneUpd:boolean=false
  passwordUpd:boolean=false
  profileUpd:boolean=true
  data:any=[]
  playersInsert:string="http://localhost:8080/player/insert-player"
  roleData:any=[]
  dta:any=[]
  constructor(private http:HttpClient,private router: Router,private route: ActivatedRoute){
    this.getRole()
    this.getData()
    
  }
  getData(){
    this.route.paramMap.subscribe(params => {
      this.id = params.get('data');
      if(this.id==null)
      {
        this.router.navigate(['/login']);
      }
      else{
        //alert(this.id)
          this.getCookieLogin()
      }
    });
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
  updateEmain(){
    this.emailUpd=true
    this.phoneUpd=false
    this.profileUpd=false
    this.passwordUpd=false
    
  }
  updatephone(){
    this.emailUpd=false
    this.phoneUpd=true
    this.profileUpd=false
    this.passwordUpd=false
  }
  updateprofile(){

    this.emailUpd=false
    this.phoneUpd=false
    this.profileUpd=true
    this.passwordUpd=false
  }
  updatepass(){
    this.emailUpd=false
    this.phoneUpd=false
    this.passwordUpd=true
    this.profileUpd=false
  }
  updateRole(){
   this.roleup=!this.roleup
  }
  getCookieLogin() {
    
    this.http.get("http://localhost:8080/player/find-by-id/"+this.id).subscribe(
      (data) => {
        
       this.data=data
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }

  getLoginData() {
    this.http.get("http://localhost:8080/player/find-by-id/").subscribe(
      (data) => {
        
       
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }


  serchById(id:string){
    this.http.get("http://localhost:8080/player/find-by-id/"+id).subscribe(
      (data)=>{
        this.dta=data
      }
      ,(error)=>{
        alert("Error")
      }
    )
    if(confirm("You want to update"))

    this.insertdata(this.dta)
  }
  insertdata(dra:any){
  
    this.fmdata.get('playerid')?.setValue(dra.playerid)
    this.fmdata.get('name')?.setValue(dra.name)
    this.fmdata.get('email')?.setValue(dra.email)
    this.fmdata.get('phonenumber')?.setValue(dra.phonenumber)
    this.fmdata.get('address')?.setValue(dra.address)
    this.fmdata.get('gen')?.setValue(dra.gen)
    this.fmdata.get('sd')?.setValue(dra.sd)
    
    this.fmdata.get('password')?.setValue(dra.password)
    this.fmdata.get('dob')?.setValue(dra.dob)
    this.http.post(this.playersInsert,this.fmdata.value).subscribe(
      (data) => {
        
        alert("Update Role")
        this.getRole()
      },
      (eror) => {
       alert("Errors")
        console.log(eror);
      }
    );
  }
  getRole(){
    this.http.get("http://localhost:8080/player/display-players-role").subscribe(
      (data)=>{
        this.roleData=data
      }
      ,(error)=>{
        alert("Error")
      }
    )
  }
}
