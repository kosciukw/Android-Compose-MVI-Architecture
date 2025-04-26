package pl.kosciukw.petsify.shared.network

import pl.kosciukw.petsify.shared.error.CoreDomainError

fun <T> networkRequest(
    networkStateProvider: NetworkStateProvider,
    apiCall: () -> T
): T =
    if (networkStateProvider.isInternetConnectionAvailable()) apiCall()
    else throw CoreDomainError.NoInternetConnection("From network request in network state provider")

suspend fun <T> suspendNetworkRequest(
    networkStateProvider: NetworkStateProvider,
    apiCall: suspend () -> T
): T =
    if (networkStateProvider.isInternetConnectionAvailable()) apiCall()
    else throw CoreDomainError.NoInternetConnection("From suspend network request in network state provider")