fun main() {
    val cuenta1 = Cuenta("123")
    val cuenta2 = Cuenta("456")
    cuenta2.saldoDisponible = 700.0

    val persona = Persona("12345678A")
    persona.agregarCuenta(cuenta1)
    persona.agregarCuenta(cuenta2)

    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPago(750.0)

    println("La persona es morosa: ${persona.esMorosa()}")

    val transferenciaExitosa = persona.realizarTransferencia(persona, 0, 1, 300.0)

    println("Transferencia realizada con éxito: $transferenciaExitosa")

    println("Estado de la persona después de la transferencia:")
    for (cuenta in persona.cuentas) {
        println("Número de cuenta: ${cuenta?.numeroCuenta}, Saldo: ${cuenta?.consultarSaldo()}")
    }
}