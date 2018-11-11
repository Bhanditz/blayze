package com.tradeshift.blayze

import cern.jet.stat.Gamma.logGamma
import java.lang.Math.log
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * log pdf of the student t-distribution
 * Equal to scipy.stats.t.logpdf
 */
fun logStudentT(x: Double, df: Double, loc: Double, scale: Double): Double {
    val normed = (x - loc) / scale
    return logGamma((df + 1.0) / 2.0) - (log(sqrt(df * PI))) - logGamma(df / 2.0) - ((df + 1.0) / 2.0) * log(1.0 + normed.pow(2.0) / df) - log(scale)
}

/**
 * Log of the beta function
 * Equal to scipy.special.betaln
 */
fun logBeta(a: Double, b: Double): Double {
    return logGamma(a) + logGamma(b) - logGamma(a + b)
}