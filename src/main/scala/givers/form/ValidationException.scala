package givers.form

object ValidationMessage {
  def addPrefix(prefix: String, base: String) = {
    if (base.isEmpty) {
      prefix
    } else {
      s"$prefix.$base"
    }
  }
}

class ValidationMessage(val key: String, val args: Any*) {
  override def toString = {
    s"ValidationMessage($key, ${args.mkString(", ")})"
  }

  def addPrefix(prefix: String): ValidationMessage = {
    new ValidationMessage(
      key = ValidationMessage.addPrefix(prefix, key),
      args = args:_*
    )
  }

  def prependArg(arg: Any): ValidationMessage = {
    new ValidationMessage(
      key = key,
      args = Seq(arg) ++ args:_*
    )
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[ValidationMessage]

  override def equals(other: Any): Boolean = other match {
    case that: ValidationMessage =>
      (that canEqual this) &&
        key == that.key &&
        args == that.args
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(key, args)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ValidationException(val messages: Seq[ValidationMessage]) extends RuntimeException {
  override def toString = {
    s"ValidationException($messages)"
  }

  def addPrefix(key: String) =  new ValidationException(messages.map(_.addPrefix(key)))

  def canEqual(other: Any): Boolean = other.isInstanceOf[ValidationException]

  override def equals(other: Any): Boolean = other match {
    case that: ValidationException =>
      (that canEqual this) &&
        messages == that.messages
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(messages)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
