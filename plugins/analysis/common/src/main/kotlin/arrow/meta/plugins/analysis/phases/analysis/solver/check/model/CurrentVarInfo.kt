package arrow.meta.plugins.analysis.phases.analysis.solver.check.model

import arrow.meta.continuations.ContSeq
import arrow.meta.plugins.analysis.phases.analysis.solver.ast.context.elements.Element
import org.sosy_lab.java_smt.api.BooleanFormula

data class CurrentVarInfo(val varInfo: MutableList<VarInfo>) {

  fun get(name: String): VarInfo? =
    varInfo.firstOrNull { it.name == name }

  fun add(name: String, smtName: String, origin: Element, invariant: BooleanFormula?) {
    varInfo.add(0, VarInfo(name, smtName, origin, invariant))
  }

  fun bracket(): ContSeq<Unit> = ContSeq {
    val currentVarInfo = varInfo.toList()
    yield(Unit)
    varInfo.clear()
    varInfo.addAll(currentVarInfo)
  }
}