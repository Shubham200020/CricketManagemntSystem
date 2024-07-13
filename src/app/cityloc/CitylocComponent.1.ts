import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { city, state } from '../Entity/locations';



@Component({
  selector: 'app-cityloc',
  standalone: true,
  imports: [HttpClientModule, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './cityloc.component.html',
  styleUrl: './cityloc.component.css'
})
export class CitylocComponent {
  
  displayCity:string="http://localhost:8080/location/display-city"//GetMapping
  insertUrl:string="http://localhost:8080/location/update-city/"//PostMapping
  dataList: any = [];
  variable:any="";
  cty: any = [];
  
  
  fmData: FormGroup = new FormGroup({
    cityid: new FormControl(null, [Validators.required,Validators.pattern('[0-9]*')]),
    cotyname: new FormControl('', [Validators.required]),
   
  });
  
  
  fmData1: FormGroup = new FormGroup({
    state: new FormControl('')
  });
  
  
  get stateId():any{
    return this.fmData1.get('state')?.value.stateid
  }


  constructor(private http: HttpClient) {
    this.getDate();
    this.findCity();
  } 
 
  get getErrCtId():any{
    return this.fmData.get('cityid')
  }
  
  getDate() {
    this.http.get("http://localhost:8080/location/show-data").subscribe(
      (data) => {
        
        this.dataList = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }
  
  findCity(){
    this.http.get(this.displayCity).subscribe(
      (data) => {
        
        this.cty=data; 
      },
      (eror) => {
        console.log(eror);
      }
    );
  }
  
  sub1(fm: FormGroup){

  }
  
  sub(fm: FormGroup) {
    
    this.http.post(this.insertUrl+this.stateId,this.fmData.value).subscribe(
      (data) => {
        alert("Insert Succesfully")
        this.cty=data; 
      },
      (eror) => {
        alert("error in enter")
        console.log(eror);
      }
    );
  }
}
