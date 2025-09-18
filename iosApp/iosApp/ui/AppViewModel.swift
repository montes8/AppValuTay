//
//  AppViewModel.swift
//  iosApp
//
//  Created by Tayler Montesinos on 15/09/2025.
//

import Foundation
import Shared

@MainActor
class  SplashViewModel :ObservableObject{

  
    let usesCases = KoinHelper()
    
    @Published var successToken : Bool = false
   
    
    func getToken() async{
        do {
            var currentUser = try await usesCases.saveUser()
           var response = try await usesCases.getUser()
           
                       print("tagDataTay")
                       print(response)
                } catch {
                    print("tagDataTayErrorrrrrr")
                }
        
      }
    
}
