package com.apress.springenterpriserecipes.replicator;

import java.io.IOException;

public interface FileCopier {

	public void copyFile(String srcDir, String destDir, String filename) throws IOException;
}
