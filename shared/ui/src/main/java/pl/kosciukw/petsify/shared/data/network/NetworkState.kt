package pl.kosciukw.petsify.shared.data.network

sealed class NetworkState {

    data object Established : NetworkState()

    data object Disconnected : NetworkState()
}