//
//  ChangeColorXIB.swift
//  SampleCustomView
//
//  Created by Bhupendra Trivedi on 19/12/19.
//  Copyright © 2019 Bhupendra Trivedi. All rights reserved.
//

import UIKit

class ChangeColorExpB: UIView {
  
  override init(frame: CGRect) {
    super.init(frame: frame)
  }
  
  required init?(coder: NSCoder) {
    super.init(coder: coder)
  }
    
    @IBOutlet var changeColorButtonInCustomView: UIButton!
    
    @IBAction func changeColorButtonTappedInCustomView(_ sender: Any) {
        let colors: [UIColor] = [UIColor.red, UIColor.green, UIColor.yellow, UIColor.orange, UIColor.black, UIColor.purple, UIColor.blue]
        let randomColorIndex = arc4random() % 6
        self.backgroundColor = colors[Int(randomColorIndex)]
    }
}
