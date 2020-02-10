package ro.dg.demofile.commands

import ro.dg.demofile.filesystem.State

trait Command {

  def apply(state: State): State

}


object Command {
  val MKDIR = "mkdir"
  val LS = "ls"

  def emptyComand: Command = new Command {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(name + " incomplete command!")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyComand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    }else if(LS.equals(tokens(0)))
      new Ls
    else new UnknownCommand
  }
}