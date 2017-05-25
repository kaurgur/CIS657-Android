//
//  GeoCalcButton.swift
//  GeoCalculator
//
//  Created by Gursimran Kaur and Sahana Gunaseker on 5/25/17.
//  Copyright © 2017 Jonathan Engelsma. All rights reserved.
//

import UIKit

class GeoCalcButton: UIButton {

    override func awakeFromNib() {
        self.backgroundColor = FOREGROUND_COLOR
        
        self.setTitleColor(BACKGROUND_COLOR, for: .normal)
        self.clipsToBounds = true
        self.layer.cornerRadius = 5.0
        self.layer.borderWidth = 1.0
        
        
       
    }
    


}
