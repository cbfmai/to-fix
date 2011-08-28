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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixTimeInForceRules
{

	public int noTimeInForceRules;
	public TimeInForceRules[] group;

	public void getAll(int noTimeInForceRules, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noTimeInForceRules = noTimeInForceRules;

		if (noTimeInForceRules < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noTimeInForceRules ).getBytes(), FixTags.NOTIMEINFORCERULES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noTimeInForceRules) {
			group = new TimeInForceRules[noTimeInForceRules];

			for ( int i = 0; i < noTimeInForceRules; i++ ) group[i] = new TimeInForceRules();
	}

		for ( int i = 0; i < noTimeInForceRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTimeInForceRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTimeInForceRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTimeInForceRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTimeInForceRules)) return false;

		FixTimeInForceRules msg = (FixTimeInForceRules) o;

		for (int i = 0; i<noTimeInForceRules; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTimeInForceRules; i++)
			s += group[i].toString();
		return s;
	}

public class TimeInForceRules implements FixComponent
{

	public byte timeInForce = (byte)' ';

	public TimeInForceRules() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		timeInForce = Byte.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.TIMEINFORCE_INT) {
				timeInForce = FixUtils.getTagCharValue(null ,id ,value );
				if (!FixMessageInfo.TimeInForce.isValid(timeInForce) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + timeInForce + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		if (FixUtils.isSet(timeInForce)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(timeInForce)) FixUtils.putFixTag( out, FixTags.TIMEINFORCE_INT, timeInForce );
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

			if (FixUtils.isSet(timeInForce)) s += "TimeInForce(59)=" + String.valueOf(timeInForce) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TimeInForceRules)) return false;

			TimeInForceRules msg = (TimeInForceRules) o;

		if (!( timeInForce==msg.timeInForce)) return false;

		return true;
	}
}
}
