package com.github.alien.tool;

import java.nio.file.Path;

public abstract class Tool {
	public abstract String getName();
	public abstract BreakingVerdict analyze(Path v1, Path v2);
}
