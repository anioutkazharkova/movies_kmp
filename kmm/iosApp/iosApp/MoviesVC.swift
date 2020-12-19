//
//  MoviesVC.swift
//  iosApp
//
//  Created by Anna Zharkova on 18.12.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import UIKit
import shared

class MoviesVC: UIViewController {
    private var adapter = MoviesAdapter()
    
    private  var service = MoviesService()
 
    private lazy var presenter: IMoviesPresenter? = {
       let presenter = MoviesPresenter()
        presenter.attachView(view: self)
        return presenter
    }()

    @IBOutlet weak var listView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.listView.register(UINib(nibName: "MoviesCell", bundle: nil), forCellReuseIdentifier: "MoviesCell")
      
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter?.attachView(view: self)
        self.listView.delegate = adapter
        self.listView.dataSource = adapter
        self.loadMovies()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter?.detachView()
        self.listView.delegate = nil
        self.listView.dataSource = nil
        super.viewWillDisappear(animated)
    }

    func loadMovies() {
        print("loading")
        self.presenter?.loadMovies()
    }
}

extension MoviesVC : IMoviesListView {
    func setupItems(items: [MovieItem]) {
        self.adapter.updateItems(items: items)
        self.listView.reloadData()
    }
    
    
}
