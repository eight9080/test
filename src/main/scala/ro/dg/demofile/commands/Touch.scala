package ro.dg.demofile.commands
import ro.dg.demofile.files.{DirEntry, File}
import ro.dg.demofile.filesystem.State

class Touch(name:String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
