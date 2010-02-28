/*
 * Copyright (c) 2010, William Bittle
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted 
 * provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice, this list of conditions 
 *     and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice, this list of conditions 
 *     and the following disclaimer in the documentation and/or other materials provided with the 
 *     distribution.
 *   * Neither the name of dyn4j nor the names of its contributors may be used to endorse or 
 *     promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Sub package of the Dynamics package handling contacts.
 * <p>
 * Contacts are solved using an iterative constraint based approach.
 * <p>
 * The {@link World} object will determine all collisions between the {@link Body}s and 
 * will turn each {@link Manifold} into a {@link ContactConstraint}.  Once all the 
 * {@link ContactConstraint}s have been gathered the {@link World} object will perform a 
 * depth first search on the {@link ContactConstraint} graph to yield {@link Island}s. 
 * The {@link Island}s will use the {@link ContactManager} to warm start the 
 * {@link ContactConstraint}s and then use the {@link ContactConstraintSolver} to solve them.
 * <p>
 * The {@link ContactListener} can be used to receive notifications of add, remove, persisted,
 * and solved events.
 */
package org.dyn4j.game2d.dynamics.contact;

import org.dyn4j.game2d.collision.manifold.Manifold;
import org.dyn4j.game2d.dynamics.Body;
import org.dyn4j.game2d.dynamics.Island;
import org.dyn4j.game2d.dynamics.World;

