// Returns true if priority is 1 or 2, 'in 1..2' checks if number is within range
fun isHighPriority(priority: Int): Boolean {
    return priority in 1..2
}

// Formats name to uppercase with "POLICY: " prefix, .trim() removes extra spaces
fun formatPolicyName(name: String): String {
    return "POLICY: ${name.trim().uppercase()}"
}

// Returns a message based on status, .lowercase() makes matching case-insensitive
fun getPolicyStatusMessage(status: String): String {
    return when (status.lowercase()) {
        "active"   -> "Policy is active and enforced."
        "inactive" -> "Policy is inactive and not enforced."
        "pending"  -> "Policy is pending approval."
        else       -> "Unknown policy status: $status" // catches anything unexpected
    }
}

fun main() {

    // true — 1 is in range, false — 3 is not
    println(isHighPriority(1))
    println(isHighPriority(3))

    // stores formatted result then prints it
    val result = formatPolicyName("firewall access")
    println(result)

    // tests each branch of the when block, "deleted" hits the else
    println(getPolicyStatusMessage("active"))
    println(getPolicyStatusMessage("inactive"))
    println(getPolicyStatusMessage("pending"))
    println(getPolicyStatusMessage("deleted"))

    // listOf() creates a read-only ordered collection
    val firewallRules = listOf(
        "Allow_HTTP",
        "Allow_HTTPS",
        "Deny_Telnet",
        "Allow_DNS",
        "Block_FTP"
    )

    // 'rule' holds the current item each loop
    for (rule in firewallRules) {
        println("Firewall Rule: $rule")
    }

    // mapOf() stores key-value pairs, policy name -> status
    val policies = mapOf(
        "Admin Access"   to "active",
        "Guest Access"   to "inactive",
        "New VPN Policy" to "pending"
    )

    // (policy, status) unpacks each pair so both parts are usable by name
    for ((policy, status) in policies) {
        println("Policy: $policy -> Status: $status")
    }

    println("Program executed successfully")
}