package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;

public class DiffVisitorError extends RuntimeException implements Cloneable {

	public static DiffVisitorError_Factory factory = new DiffVisitorError_Factory();

	public static class DiffVisitorError_Factory extends org.gravel.support.jvm.SmalltalkFactory {

		public DiffVisitorError basicNew() {
			DiffVisitorError newInstance = new DiffVisitorError();
			newInstance.initialize();
			return newInstance;
		}
	}

	public DiffVisitorError copy() {
		try {
			DiffVisitorError _temp1 = (DiffVisitorError) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public DiffVisitorError_Factory factory() {
		return factory;
	}

	public DiffVisitorError initialize() {
		return this;
	}

	public DiffVisitorError postCopy() {
		return this;
	}
}
