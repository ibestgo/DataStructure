package com.bestgo.misc;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class ShowFiles {

  public List<File> walk(String path, String ext) {
    return walk(new File(path), ext);
  }

  public List<File> walk(File path, String ext) {
    // anonymous inner class
    FileFilter filter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if (ext.equals("*")) return true;
        else {
          String name = pathname.getName();
          return pathname.isDirectory() || name.endsWith(ext);
        }
      }
    };

    List<File> list = new ArrayList<>();
    iterate(path, list, filter);
    return list;
  }

  // nested iteration
  private void iterate(File path, List<File> list, FileFilter filter) {
    if(!path.exists() || !path.isDirectory()) {
      throw new IllegalArgumentException("invalid folder path passed");
    }

    // this may not need in this case
    //if(path.listFiles() == null) return;

    for (File one : path.listFiles(filter)) {
      if (one.isDirectory()) {
        iterate(one, list, filter);
      } else {
        list.add(one);
      }
    }
  }
}
