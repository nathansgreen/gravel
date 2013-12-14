package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.VariableScopeAnalyzerState;
import org.gravel.support.parser.VariableScopeAnalyzerState.VariableScopeAnalyzerState_Factory;

public class VariableScopeAnalyzerStateWritten extends VariableScopeAnalyzerState implements Cloneable {

	public static VariableScopeAnalyzerStateWritten_Factory factory = new VariableScopeAnalyzerStateWritten_Factory();

	public static class VariableScopeAnalyzerStateWritten_Factory extends VariableScopeAnalyzerState_Factory {

		public VariableScopeAnalyzerStateWritten basicNew() {
			VariableScopeAnalyzerStateWritten newInstance = new VariableScopeAnalyzerStateWritten();
			newInstance.initialize();
			return newInstance;
		}
	}

	public VariableScopeAnalyzerStateWritten copy() {
		try {
			VariableScopeAnalyzerStateWritten _temp1 = (VariableScopeAnalyzerStateWritten) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public VariableScopeAnalyzerStateWritten_Factory factory() {
		return factory;
	}

	@Override
	public VariableScopeAnalyzerState withBlockRead() {
		return VariableScopeAnalyzerStateBlockReadAfterWritten.factory.basicNew();
	}

	@Override
	public VariableScopeAnalyzerState withLocalRead() {
		return VariableScopeAnalyzerStateReadWritten.factory.basicNew();
	}

	@Override
	public VariableScopeAnalyzerState withLocalWrite() {
		return this;
	}
}
