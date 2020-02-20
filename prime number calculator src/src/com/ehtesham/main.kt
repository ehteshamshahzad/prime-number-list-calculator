package com.ehtesham

import kotlin.math.roundToInt

var iterations: Long = 0

fun main(args: Array<String>) {

    val limit = 1000.0 //Set limit
    var listOfPrime: MutableList<Int> = mutableListOf()

    listOfPrime.add(2)
    listOfPrime = calculatePrimeLessThan19(limit, listOfPrime)
    listOfPrime = calculatePrimeGreaterThan19(limit, listOfPrime)
    result(listOfPrime)
}

fun calculatePrimeLessThan19(limit: Double, listOfPrime: MutableList<Int>): MutableList<Int> {

    for (count in 3 until 18 step 2) {
        if (count > limit) {
            break
        }

        var isPrime = false
        for (num in listOfPrime) {
            iterations++

            if (count % num == 0) {
                isPrime = false
                break
            } else {
                isPrime = true
            }
        }

        if (isPrime) {

            listOfPrime.add(count)
        }
    }
    return listOfPrime
}

fun calculatePrimeGreaterThan19(limit: Double, listOfPrime: MutableList<Int>): MutableList<Int> {
    for (count in 19 until limit.roundToInt() step 2) {

        var isPrime = false
        var counter = 1

        while (counter < (listOfPrime.size / 2) - 1) {
            iterations++

            if (count % listOfPrime[counter] == 0) {
                isPrime = false
                break
            } else {
                isPrime = true
            }

            counter++
        }

        if (isPrime) {

            listOfPrime.add(count)
        }
    }
    return listOfPrime
}

fun result(listOfPrime: MutableList<Int>) {
    println(listOfPrime)
    println("Number of iterations: $iterations")
}