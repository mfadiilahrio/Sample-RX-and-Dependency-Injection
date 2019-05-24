package com.example.rxsample.common.dependency_class

import javax.inject.Inject

class Dhouse {
    @Inject
    lateinit var dnormal: Dnormal

    @Inject
    lateinit var dunique: Dunique
}