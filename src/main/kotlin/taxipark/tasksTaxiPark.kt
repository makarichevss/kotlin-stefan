package taxipark

fun TaxiPark.findFaleDrivers(): Set<Driver> =
    allDrivers - trips.map { it.driver }.toSet()

fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    trips
        .flatMap(Trip::passengers)
        .groupBy { it }
        .filterValues { group -> group.size >= minTrips }
        .keys

fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) =
        trips.partition { it.discount != null }
    return allPassengers
        .filter { passenger ->
            tripsWithDiscount.count { passenger in it.passengers } >
                tripsWithoutDiscount.count { passenger in it.passengers }
        }.toSet()
}

fun TaxiPark.findFrequestTripsTime(): IntRange {
    return trips
        .groupBy {
            val start = it.duration / 10 * 10
            val end = start + 9
            start..end
        }
        .maxBy { (_, group) -> group.size }
        .key
}

fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumOf(Trip::cost)
    val sortedDrivesIncome: List<Double> = trips
        .groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumOf(Trip::cost) }
        .sortedDescending()

    val numberOfTopDrives = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedDrivesIncome
        .take(numberOfTopDrives)
        .sum()

    return incomeByTopDrivers >= 0.8 * totalIncome
}
