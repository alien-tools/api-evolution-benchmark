package com.github.alien.tool;

/** What a tool (or the ground truth) says about one case. */
public record BreakingVerdict(boolean isBinaryBreaking, boolean isSourceBreaking, String message) {
	public boolean isBreaking() {
		return isBinaryBreaking || isSourceBreaking;
	}
}
