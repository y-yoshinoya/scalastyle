// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalastyle.scalariform

import org.scalastyle.file.CheckerTest
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.scalastyle.Checker
import org.scalastyle.StyleError
import java.util.Set
import org.junit.Before
import org.junit.Test

// scalastyle:off magic.number

class PublicMethodsHaveTypeCheckerTest extends AssertionsForJUnit with CheckerTest {
  val key = "public.methods.have.type"
  val classUnderTest = classOf[PublicMethodsHaveTypeChecker]

  @Test def testClassOK() {
    val source = """
package foobar

class OK {
  def c1() = 5
  def c2(): Int = 5
  def c3 = 5
  protected def c4() = 5
  private def c5() = 5
  private[this] def c6() = 5
  private val foo1 = 1
  val foo2 = 2
  def unit = {}
  def unit {}
}
""";

    assertErrors(List(columnError(5, 6), columnError(7, 6), columnError(13, 6)), source)
  }
}
