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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;

public class FixInstrmtStrkPxGrp
{

	public int noStrikes;
	public InstrmtStrkPxGrp[] group;

	public void getAll(int noStrikes, ByteBuffer buf) throws FixSessionException {
		this.noStrikes = noStrikes;

		if (noStrikes < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noStrikes) 
			group = new InstrmtStrkPxGrp[noStrikes];

		for ( int i = 0; i < noStrikes; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noStrikes; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noStrikes; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noStrikes; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noStrikes; i++)
			s += group[i].toString();
		return s;
	}

public class InstrmtStrkPxGrp implements FixComponent
{

	public long prevClosePx = 0;
	public byte[] clOrdID;
	public byte[] secondaryClOrdID;
	public byte side = (byte)' ';
	public long price = 0;
	public byte[] currency;
	public byte[] text;
	public long encodedTextLen = 0;
	public FixInstrument instrument;
	public FixUndInstrmtGrp undInstrmtGrp;
	public byte[] encodedText;

	public InstrmtStrkPxGrp() {
		super();

		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp();
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		prevClosePx = Long.MAX_VALUE;		
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		side = Byte.MAX_VALUE;		
		price = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		instrument.clear();
		undInstrmtGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PREVCLOSEPX_INT) {
				prevClosePx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLORDID_INT) {
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYCLORDID_INT) {
				secondaryClOrdID = FixUtils.getTagStringValue(value, secondaryClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICE_INT) {
				price = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TEXT_INT) {
				text = FixUtils.getTagStringValue(value, text);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXTLEN_INT) {
				encodedTextLen = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOUNDERLYINGS_INT) {
				undInstrmtGrp.getAll(FixTags.NOUNDERLYINGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXT_INT) {
				encodedText = FixUtils.getTagStringValue(value, encodedText);
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

		if (! instrument.isSet() ) return FixTags.SYMBOL_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(prevClosePx)) return true;
		if (FixUtils.isSet(clOrdID)) return true;
		if (FixUtils.isSet(secondaryClOrdID)) return true;
		if (FixUtils.isSet(side)) return true;
		if (FixUtils.isSet(price)) return true;
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(prevClosePx)) FixUtils.putFixFloatTag( out, FixTags.PREVCLOSEPX_INT, prevClosePx);
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(price)) FixUtils.putFixFloatTag( out, FixTags.PRICE_INT, price);
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
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

			if (FixUtils.isSet(prevClosePx)) s += "PrevClosePx(140)=" + String.valueOf(prevClosePx) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(price)) s += "Price(44)=" + String.valueOf(price) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrmtStrkPxGrp)) return false;

			InstrmtStrkPxGrp msg = (InstrmtStrkPxGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( prevClosePx==msg.prevClosePx)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!( side==msg.side)) return false;

		if (!( price==msg.price)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
}