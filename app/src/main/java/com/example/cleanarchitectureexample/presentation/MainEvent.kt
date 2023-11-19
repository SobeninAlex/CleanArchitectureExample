package com.example.cleanarchitectureexample.presentation

interface MainEvent

class SaveEvent(val text: String) : MainEvent

class LoadEvent : MainEvent