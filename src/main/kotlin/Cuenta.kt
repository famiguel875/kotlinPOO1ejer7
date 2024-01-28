class Cuenta(val numeroCuenta: String) {
    var saldoDisponible: Double = 0.0

    fun consultarSaldo(): Double {
        return saldoDisponible
    }

    fun recibirAbono(monto: Double) {
        saldoDisponible += monto
    }

    fun realizarPago(monto: Double): Boolean {
        if (saldoDisponible >= monto) {
            saldoDisponible -= monto
            return true
        }
        return false
    }
}