//
//  GeoCalcTextField.swift
//  GeoCalculator
//
//  Created by Gursimran Kaur and Sahana Gunaseker on 5/25/17.
//  Copyright © 2017 Jonathan Engelsma. All rights reserved.
//

import UIKit

class GeoCalcTextField: DecimalMinusTextField {
    override func awakeFromNib() {
        //super.awakeFromNib()
        self.backgroundColor = BACKGROUND_COLOR
        self.backgroundColor = UIColor.clear
        
        
        self.layer.cornerRadius = 5.0
        self.layer.borderWidth = 1.0
        self.borderStyle = .roundedRect
        self.layer.borderColor = FOREGROUND_COLOR.cgColor
        
         self.textColor = FOREGROUND_COLOR
        
        guard let ph = self.placeholder  else {
            return
        }
        
        self.attributedPlaceholder =
            NSAttributedString(string: ph, attributes: [NSForegroundColorAttributeName :
                FOREGROUND_COLOR])
    }
}
