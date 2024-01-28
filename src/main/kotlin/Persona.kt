class Persona(val dni: String) {
    val cuentas: Array<Cuenta?> = arrayOfNulls(3)

    fun agregarCuenta(cuenta: Cuenta): Boolean {
        for (i in cuentas.indices) {
            if (cuentas[i] == null) {
                cuentas[i] = cuenta
                return true
            }
        }
        return false
    }

    fun esMorosa(): Boolean {
        for (cuenta in cuentas) {
            if (cuenta?.saldoDisponible ?: 0.0 < 0.0) {
                return true
            }
        }
        return false
    }

    fun realizarTransferencia(
        personaDestino: Persona,
        cuentaOrigenIdx: Int,
        cuentaDestinoIdx: Int,
        monto: Double
    ): Boolean {
        val cuentaOrigen = cuentas[cuentaOrigenIdx]
        val cuentaDestino = personaDestino.cuentas[cuentaDestinoIdx]

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.realizarPago(monto)) {
            cuentaDestino.recibirAbono(monto)
            return true
        }

        return false
    }
}