package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixStrategyParametersGrp
{

	public int noStrategyParameters;
	public StrategyParametersGrp[] group;

	public void getAll(int noStrategyParameters, ByteBuffer buf) throws FixSessionException {
		this.noStrategyParameters = noStrategyParameters;

		if (noStrategyParameters < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noStrategyParameters) 
			group = new StrategyParametersGrp[noStrategyParameters];

		for ( int i = 0; i < noStrategyParameters; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noStrategyParameters; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noStrategyParameters; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noStrategyParameters; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noStrategyParameters; i++)
			s += group[i].toString();
		return s;
	}

public class StrategyParametersGrp implements FixComponent
{

	public byte[] strategyParameterName;
	public long strategyParameterType = 0;
	public byte[] strategyParameterValue;

	public StrategyParametersGrp() {
		super();

		strategyParameterName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		strategyParameterValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( strategyParameterName, (byte)0 );
		strategyParameterType = Long.MAX_VALUE;		
		Utils.fill( strategyParameterValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.STRATEGYPARAMETERNAME_INT) {
				strategyParameterName = FixUtils.getTagStringValue(value, strategyParameterName);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STRATEGYPARAMETERTYPE_INT) {
				strategyParameterType = FixUtils.getTagIntValue( value );
				if (!StrategyParameterType.isValid(strategyParameterType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + strategyParameterType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STRATEGYPARAMETERVALUE_INT) {
				strategyParameterValue = FixUtils.getTagStringValue(value, strategyParameterValue);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(strategyParameterName)) return true;
		if (FixUtils.isSet(strategyParameterType)) return true;
		if (FixUtils.isSet(strategyParameterValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(strategyParameterName)) FixUtils.putFixTag( out, FixTags.STRATEGYPARAMETERNAME_INT, strategyParameterName, 0, Utils.lastIndexTrim(strategyParameterName, (byte)0) );
		if (FixUtils.isSet(strategyParameterType)) FixUtils.putFixTag( out, FixTags.STRATEGYPARAMETERTYPE_INT, strategyParameterType);
		if (FixUtils.isSet(strategyParameterValue)) FixUtils.putFixTag( out, FixTags.STRATEGYPARAMETERVALUE_INT, strategyParameterValue, 0, Utils.lastIndexTrim(strategyParameterValue, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(strategyParameterName)) s += "StrategyParameterName(958)=" + new String(strategyParameterName) + sep;
			if (FixUtils.isSet(strategyParameterType)) s += "StrategyParameterType(959)=" + String.valueOf(strategyParameterType) + sep;
			if (FixUtils.isSet(strategyParameterValue)) s += "StrategyParameterValue(960)=" + new String(strategyParameterValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof StrategyParametersGrp)) return false;

			StrategyParametersGrp msg = (StrategyParametersGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( strategyParameterName, msg.strategyParameterName)) return false;

		if (!( strategyParameterType==msg.strategyParameterType)) return false;

		if (!Utils.equals( strategyParameterValue, msg.strategyParameterValue)) return false;

		return true;
	}
}
}
