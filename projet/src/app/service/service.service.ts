import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Events } from '../models/events';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private  BaseUrl="http://localhost:3000/Events";
  private  BaseUser="http://localhost:3000/User";

  constructor(private http:HttpClient) { }

  ajout(Events:Events)
  {
    return this.http.post(this.BaseUrl,Events);
   }

   getEvents():Observable<void>
   { 
    return this.http.get<void>(this.BaseUrl)
  }  

  getEventsbyid(id:any):Observable<any>
  { 
   return this.http.get<any>(this.BaseUrl+'/'+id)
 }  
 getUser():Observable<User>
 { 
  return this.http.get<User>(this.BaseUser)
}  

saveUser(User:User)
{ return this.http.post(this.BaseUser,User)}



}
