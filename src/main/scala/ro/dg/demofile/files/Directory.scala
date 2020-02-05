package ro.dg.demofile.files

class Directory(override val parentPath: String, override val name: String, val contents: List[Directory])
  extends DirEntry(parentPath, name) {



}

object Directory{
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "")

  def empty(parentPath: String, name:String): Directory =
    new Directory(parentPath, name, List())


}

