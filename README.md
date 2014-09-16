== Comparing Java Web Framework (JWF) Implementations

This is a set of Java Web Framework "hello form" (sign-up)
demonstration implementations. Each shows a simple webapp that
allows the user to enter standard "signup" data, and puts it
into a database, and lets you list the database.

This work was started over a decade ago(!), as part of my M.Sc. work and has been continued -
very sporadically - as a sort of hobby.  There are 100 Java Web
Frameworks and only a dozen or so implementations here, so you can see
that the coverage is sporadic at best.

The jwf-datamodel is common code that some of the impls use, or should.
Its Person class provides the quasi-canonical list of fields for
the impls that don't use this standard Entity object.
You should do "mvn install" in this subdirectory before anything else!

Each jwf.* subdirectory is an Eclipse Project containing one of the implementations;
the name should make it clear which framework(s) is/are demonstrated.

The jwf. at the front of the names are preserved in the Eclipse .project files so that
if you add these to an existing Eclipse workspace, they will all cluster together.

Do not expect consistency about the batch build system; some use Ant,
some use Maven, maybe by the time you use this, some will use Gradle.
Some probably have no build file.

No claim is made that these are "best practices" versions;
some are very old and could be updated! Caveat hactor: beware
of bit rot, defunct frameworks, etc.

Some of the projects that are still useful should be re-organized
to not have everything in the root folder; proper Maven/Gradle build
structure, dependencies, etc.

Please contribute fixes, improvements, your own implementations, etc.
As with any public GitHub project, clone it, hack, send a pull request.

Impls I'd like to see, or do:

* Grails
* Or actually anything else you'd like to send!
	
Regards,

Ian Darwin
