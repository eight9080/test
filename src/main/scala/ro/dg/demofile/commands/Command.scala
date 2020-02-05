package ro.dg.demofile.commands

import ro.dg.demofile.filesystem.State

trait Command {

  def apply(state: State): State

}


object Command{
  def from(input: String): Command =
    new UnknownCommand
}