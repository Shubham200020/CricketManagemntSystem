export class state {
    city:any
    stateid:string
    statename:string
    constructor(stateid:string,city:any,statename:string){
        this.stateid=stateid
        this.city=city
        this.statename=statename
    }

}
export class city{
    cityid:string
    cotyname:string
    constructor(cityid:string,cotyname:string){
        this.cityid=cityid
        this.cotyname=cotyname
    }
}