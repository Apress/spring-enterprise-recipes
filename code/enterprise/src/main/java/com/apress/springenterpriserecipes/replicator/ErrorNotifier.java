package com.apress.springenterpriserecipes.replicator;

public interface ErrorNotifier {

	public void notifyCopyError(String srcDir, String destDir, String filename);
}
