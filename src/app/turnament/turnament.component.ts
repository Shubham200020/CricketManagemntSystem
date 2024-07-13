import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-turnament',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule,HttpClientModule],
  templateUrl: './turnament.component.html',
  styleUrl: './turnament.component.css'
})
export class TurnamentComponent {
  turnament:any=[]
  player:any=[]
  player1:any=[]
  player2:any=[]
  playerData1:any=[]
  playerData2:any=[]
  data:any=[]
  id:string=""
  indic:boolean=false
  constructor(private http:HttpClient){
    this.getTurnament()
  
  }
  insertPlays(i:any){
    this.id=i.turnamentid
    this.getPlayer(i.turnamentid)
    this.findTurnament(i)
    this.project(i.turnamentid)
  }
  getPlayer(id:any) {
    
    this.http.get("http://localhost:8080/turnament/display/matchPlayer/"+id).subscribe(
      (data) => {
    
        this.player = data;
      },
      (eror) => {
       alert("Error")
        console.log(eror);
      }
    );
    
  }
  insertPlayers(turnament:any,player:any,side:string){
    this.http.post("http://localhost:8080/turnament/add-turnament-team/"+turnament.turnamentid+"/"+side,player).subscribe(
      (data) => {
        alert("Insert Data")
       //this.turnament=data
      },
      (eror) => {
       
        console.log(eror);
      }
    );
    this.insertPlays(turnament)
    this.players1(this.id);
    this.players2(this.id)
  }
  project(id:any){
    this.players1(id);
    this.players2(id)
  }
  players1(id:string){
    
    this.http.get("http://localhost:8080/turnament/display-players-team1/"+id).subscribe(
      (data) => {
        
        this.player1 = data;
       
      },
      (eror) => {
       
        console.log(eror);
      }
    );
   
  }
  players2(id:string){
 
    this.http.get("http://localhost:8080/turnament/display-players-team2/"+id).subscribe(
      (data) => {
        
        this.player2 = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }
  findTurnament(data:any){
    //this.indic=true
   
    this.data=data
    this.data.team1=this.player1
    
   /* this.http.get("http://localhost:8080/turnament/findByIdyurnament"+data.turnamentid).subscribe(
      (data) => {
        
        this.data = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );*/
  }
  insertPlayer(){
    this.http.get("http://localhost:8080/turnament/get-turnament").subscribe(
      (data) => {
        
       this.turnament=data
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }
  getTurnament(){
    this.http.get("http://localhost:8080/turnament/get-turnament").subscribe(
      (data) => {
        
       this.turnament=data
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }

}
