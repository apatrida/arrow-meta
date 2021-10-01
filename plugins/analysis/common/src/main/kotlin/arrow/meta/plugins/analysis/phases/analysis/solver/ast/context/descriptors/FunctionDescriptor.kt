package arrow.meta.plugins.analysis.phases.analysis.solver.ast.context.descriptors

interface FunctionDescriptor : CallableMemberDescriptor {
  val isOperator: Boolean
  val isInfix: Boolean
  val isInline: Boolean
  val isTailrec: Boolean
  val isSuspend: Boolean
}