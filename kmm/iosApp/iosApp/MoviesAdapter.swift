//
//  MoviesAdapter.swift
//  iosApp
//
//  Created by Anna Zharkova on 18.12.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class MoviesAdapter : NSObject,  UITableViewDelegate, UITableViewDataSource {
    private var items: [MovieItem] = [MovieItem]()
    
    func updateItems(items: [MovieItem]) {
        self.items = [MovieItem]()
        self.items.append(contentsOf: items)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "MoviesCell", for: indexPath) as? MoviesCell else {
            return UITableViewCell()
        }
        
        cell.setupData(item: items[indexPath.row])
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
}
