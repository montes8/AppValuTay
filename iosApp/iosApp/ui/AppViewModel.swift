//
//  AppViewModel.swift
//  iosApp
//
//  Created by Tayler Montesinos on 15/09/2025.
//

import Foundation
import Shared

class  SplashViewModel :ObservableObject{

  
    let usesCases = KoinHelper()
    
    @Published var successToken : Bool = false
   
    
    func getToken(){
        var response = usesCases.getSession()
        print(String(response))
      }
    
}
