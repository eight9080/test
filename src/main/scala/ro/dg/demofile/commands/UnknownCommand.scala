package ro.dg.demofile.commands
import ro.dg.demofile.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State =
    state.setMessage("Command not found!")
}
